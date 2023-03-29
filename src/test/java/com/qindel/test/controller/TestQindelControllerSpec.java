package com.qindel.test.controller;

import com.qindel.test.service.TestQindelService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TestQindelController.class)
@Slf4j
@AutoConfigureTestDatabase
@TestPropertySource(locations = "classpath:application-test.properties")

public class TestQindelControllerSpec {

  @MockBean
  TestQindelService service;



  @Autowired
  private MockMvc mockMvc;

  @Autowired
  TestQindelController controller;


  @Test
  @Sql({"classpath:/data.sql"})
  void test1() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
      .get("/e-commerce/prices/2020-06-14T10:00:00/35455/1")
    ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
  }


  @Test
  @Sql({"classpath:/data.sql"})
  void test2() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
      .get("/e-commerce/prices/2020-06-14T16:00:00/35455/1")
    ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
  }

  @Test
  @Sql({"classpath:/data.sql"})
  void test3() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
      .get("/e-commerce/prices/2020-06-14T21:00:00/35455/1")
    ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
  }

  @Test
  @Sql({"classpath:/data.sql"})
  void test4() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
      .get("/e-commerce/prices/2020-06-15T10:00:00/35455/1")
    ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
  }


  @Test
  @Sql({"classpath:/data.sql"})
  void test5() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
      .get("/e-commerce/prices/2020-06-16T21:00:00/35455/1")
    ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
  }


}
