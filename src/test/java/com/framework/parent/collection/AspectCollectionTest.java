package com.framework.parent.collection;

import com.framework.parent.collection.AspectCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author luodong
 * @date 2022/3/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AspectCollectionTest {

    @Autowired
    AspectCollection aspectCollection;

    @Test
    public void add() {
        aspectCollection.toTestAspect();
    }

}
