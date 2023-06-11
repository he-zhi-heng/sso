package com.he.commons.result;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author hemoren
 */
@Data
public class JsonPage<T>  implements Serializable {
    //按照实际需求定义类中的属性
    /**
     * 当前页码
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 总记录数
     */
    private Long totalCount;
    /**
     * 总页数
     */
    private Integer totalPages;
    //声明属性,封装查询到的分页数据的结果
    /**
     * 查询结果
     * example = "[{},{}]"
     */
    private List<T> list;
    //所有属性写完,编写将其他框架分页结果转换为当前类对象的方法
    //SpringDataElasticsearch或PageHelper等具有分页功能的框架,均有类似PageInfo的类
    //分别编写方法将他们转化成JsonPage对象

    public static <T> JsonPage<T> restPage(PageInfo<T> pageInfo){
        //下面开始将PageInfo对象转化为JsonPage对象
        JsonPage<T> jsonPage=new JsonPage<>();
        jsonPage.setPageNum(pageInfo.getPageNum());
        jsonPage.setPageSize(pageInfo.getPageSize());
        jsonPage.setTotalCount(pageInfo.getTotal());
        jsonPage.setTotalPages(pageInfo.getPages());
        jsonPage.setList(pageInfo.getList());
        return jsonPage;
    }
}
