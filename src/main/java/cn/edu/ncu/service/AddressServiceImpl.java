package cn.edu.ncu.service;

import cn.edu.ncu.dao.AddressMapper;
import cn.edu.ncu.pojo.Address;
import cn.edu.ncu.pojo.AddressExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-20.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Service
public class AddressServiceImpl implements AddressService{
    @Resource
    private AddressMapper addressMapper;

    @Override
    public Address findAddressById(Long id){
        return addressMapper.selectByPrimaryKey(BigDecimal.valueOf(id));
    }

    @Override
    public int delAddress(int id) {
        return addressMapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
    }

    @Override
    public int addAddress(Address address) {
        return addressMapper.insertSelective(address);
    }

    @Override
    public void updateDefaultAddress(Long id, Long defalutAddressId){
        if (defalutAddressId!= null){
            Address address = addressMapper.selectByPrimaryKey(BigDecimal.valueOf(defalutAddressId));
            address.setIsDefault("0");
            AddressExample example = new AddressExample();
            AddressExample.Criteria cri = example.createCriteria();
            cri.andAddressIdEqualTo(BigDecimal.valueOf(defalutAddressId));
            addressMapper.updateByExampleSelective(address,example);
        }
        Address address = addressMapper.selectByPrimaryKey(BigDecimal.valueOf(id));
        address.setIsDefault("1");
        AddressExample example = new AddressExample();
        AddressExample.Criteria cri = example.createCriteria();
        cri.andAddressIdEqualTo(BigDecimal.valueOf(id));
        addressMapper.updateByExampleSelective(address,example);
    }

    @Override
    public List<Address> findAddressByUserId(String username) {
        AddressExample example = new AddressExample();
        AddressExample.Criteria cri = example.createCriteria();
        cri.andUsernameEqualTo(username);
        cri.andIsDefaultEqualTo("0");
        List<Address> addresses = addressMapper.selectByExample(example);
        return addresses;
    }

    @Override
    public List<Address> findDefaultAddress(String username) {
        AddressExample example = new AddressExample();
        AddressExample.Criteria cri = example.createCriteria();
        cri.andUsernameEqualTo(username);
        cri.andIsDefaultEqualTo("1");
        List<Address> addresses = addressMapper.selectByExample(example);
        return addresses;
    }
}
