package cn.edu.ncu.action;

import cn.edu.ncu.dto.ProcessDefinitionDTO;
import cn.edu.ncu.dto.TaskDTO;
import cn.edu.ncu.utils.DateUtils;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-08-15
 * @Description: AgileLogistic
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Controller
@RequestMapping("/activiti")
public class ActivitiAction {

    // 直接注入工作流的服务层
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private TaskService taskService;


    @GetMapping("/cdn")
    public String registPage(){
        System.out.println("goto cdn page");
        return "cdn";
    }

    @RequestMapping("/deploy.json")
    public String deploy(HttpServletRequest request, @RequestParam("profile") CommonsMultipartFile multipartFile) throws IOException {
        InputStream in = multipartFile.getInputStream();
        ZipInputStream zipInputStream = new ZipInputStream(in);
        String name = request.getParameter("name");
        Deployment deploy = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name(name)
                .deploy();
        System.out.println("部署ID" + deploy.getId());
        return null;
    }

    @RequestMapping("/task.json")
    public ModelAndView showList(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        // 流程定义查询
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
                .list();
        List<ProcessDefinitionDTO> defiList = new ArrayList<>();
        for (ProcessDefinition processDefinition : list) {
            ProcessDefinitionDTO definitionDTO = new ProcessDefinitionDTO();
            definitionDTO.setDefinitionId(processDefinition.getId());
            definitionDTO.setKey(processDefinition.getKey());
            definitionDTO.setVersion(processDefinition.getVersion());
            defiList.add(definitionDTO);
        }
        // 集合defiList需要返回到页面上
        modelAndView.addObject("definitionList",defiList);

        // 用户的任务查询
        List<Task> taskList = taskService.createTaskQuery()
                                .list();
        List<TaskDTO> taskDTOList = new ArrayList<>();
        for (Task task : taskList) {
            // 最重要的就是任务ID
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setTaskId(task.getId());
            taskDTO.setTaskName(task.getName());
            Date createTime = task.getCreateTime();
            taskDTO.setTaskTime(DateUtils.dateToString(createTime));
            taskDTOList.add(taskDTO);
        }
        // 集合defiList需要返回到页面上
        modelAndView.addObject("taskList",taskDTOList);
        modelAndView.setViewName("gdlist");
        return modelAndView;
    }
}
