package com.wyj.testmock.jmock;

/**
 * @author wangyujue
 */
public class UserManager {
    public IAddressService addressService;

    public UserManager(IAddressService addressService) {
        this.addressService = addressService;
    }

    public int getCityCode(String username) {
        int cityCode = 0;
        String address = addressService.findAddress(username);
        if ("nanjing".equals(address)) {
            cityCode = 1;
        }
        return cityCode;
    }
}
