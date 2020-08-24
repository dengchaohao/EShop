package cn.edu.ncu.service;

import cn.edu.ncu.pojo.Address;

import java.util.List;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-20.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
public interface AddressService {
    Address findAddressById(Long id);
    int delAddress(int id);
    int addAddress(Address address);
    void updateDefaultAddress(Long id, Long defalutAddressId);
    List<Address> findAddressByUserId(String username);
    List<Address> findDefaultAddress(String username);
}
