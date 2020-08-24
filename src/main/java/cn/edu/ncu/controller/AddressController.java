package cn.edu.ncu.controller;

import cn.edu.ncu.pojo.*;
import cn.edu.ncu.service.AddressService;
import cn.edu.ncu.service.AreaService;
import cn.edu.ncu.service.CityService;
import cn.edu.ncu.service.ProvinceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-20.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Controller
public class AddressController {
    @Resource
    private AddressService addressService;
    @Resource
    private AreaService areaService;
    @Resource
    private CityService cityService;
    @Resource
    private ProvinceService provinceService;

    @RequestMapping("/setDefaultAddress")
    public ModelAndView setDefaultAddress(String id, String defaultAddressId, HttpSession session) {
        if ("".equals(defaultAddressId)){
            addressService.updateDefaultAddress(Long.valueOf(id),null);
        }else {
            addressService.updateDefaultAddress(Long.valueOf(id),Long.valueOf(defaultAddressId));
        }
        getAddress(session);
        return new ModelAndView("redirect:/order");
    }

    @RequestMapping("/updateAddress")
    public ModelAndView updateAddress(String id,String contact, String mobile, String province, String city, String town, String address, String alias,HttpSession session) {
        System.out.println(id);
        int i = addressService.delAddress(Integer.valueOf(id).intValue());
        Address tAddress = new Address();
        tAddress.setContact(contact);
        tAddress.setMobile(mobile);
        /*tAddress.setProvinceId(province);
        tAddress.setCityId(city);*/
        tAddress.setAreaId(town);
        tAddress.setAddress(address);
        tAddress.setZipCode(alias);
        User sessionUser = (User) session.getAttribute("user");
        tAddress.setUsername(sessionUser.getUsername());
        addressService.addAddress(tAddress);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/address");
        getAddress(session);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/delAddress")
    public String delAddress(String id,HttpSession session) {
        System.out.println(id);
        int i = addressService.delAddress(Integer.valueOf(id).intValue());
        if (i<=0) return "false";
        getAddress(session);
        return "success";
    }

    @RequestMapping("/addAddress")
    public ModelAndView addAddress(String contact, String mobile, String province, String city, String town, String address, String alias, HttpSession session) {
        //getAddress(session);
        Address tbAddress = new Address();
        tbAddress.setContact(contact);
        tbAddress.setMobile(mobile);
        /*tbAddress.setProvinceId(province);
        tbAddress.setCityId(city);*/
        tbAddress.setAreaId(town);
        tbAddress.setAddress(address);
        tbAddress.setZipCode(alias);
        User sessionUser = (User) session.getAttribute("user");
        tbAddress.setUsername(sessionUser.getUsername());
        addressService.addAddress(tbAddress);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/address");
        getAddress(session);
        return modelAndView;
    }

    @RequestMapping("/address")
    public ModelAndView displayAddress(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("address");
        /*ModelAndView modelAndView1 = new ModelAndView();
        modelAndView1.setViewName("login");
        TbUser sessionUser = (TbUser) session.getAttribute("user");
        if (sessionUser == null) {
            return modelAndView1;
        }*/
        //getAddress(session);
        return modelAndView;
    }

    public void getAddress(HttpSession session){
        List<Province> provinces = provinceService.findAllProvinces();
        List<City> cities = cityService.findAllCities();
        List<Area> areas = areaService.findAllAreas();
        User sessionUser = (User) session.getAttribute("user");
        List<Address> allAddresses = addressService.findAddressByUserId(sessionUser.getUsername());
        List<Address> defaultAddresses = addressService.findDefaultAddress(sessionUser.getUsername());
        Address defaultAddress = new Address();
        if (defaultAddresses.size()==0){
            defaultAddress = null;
        }else {
            defaultAddress = defaultAddresses.get(0);
        }
        if (allAddresses.size()==0){
            allAddresses = null;
        }
        session.setAttribute("allAddresses",allAddresses);
        session.setAttribute("defaultAddress",defaultAddress);
        session.setAttribute("provinces",provinces);
        session.setAttribute("cities", cities);
        session.setAttribute("areas", areas);
    }
}
