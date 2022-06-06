package com.framework.parent.design.filter;

import java.util.List;

/**
 * @author luodong
 * @date 2022/6/2
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
