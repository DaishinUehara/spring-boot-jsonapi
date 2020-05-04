package daishin.uehara.display;

import static org.junit.Assert.assertEquals;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import daishin.uehara.display.DisplayService.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class
})
public class DisplayServiceTest {

    @Autowired
    DisplayService service;

    @Test
    @DatabaseSetup("/dbunit/display.xml")
    public void test(){
        DisplayDTO dto=service.getDisplay();
        assertEquals(dto.getMdisplay().size(),2);
    }

}