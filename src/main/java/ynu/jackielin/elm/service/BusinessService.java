package ynu.jackielin.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ynu.jackielin.elm.entity.po.Business;

import java.util.List;

public interface BusinessService extends IService<Business> {

    List<Integer> getAllCategories();
}
