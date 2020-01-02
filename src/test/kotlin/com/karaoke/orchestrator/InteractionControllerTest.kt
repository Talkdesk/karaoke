package com.karaoke.orchestrator

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class InteractionControllerTest() {
    @Autowired
    private lateinit var mockController: MockMvc

    @Test
    fun testMinimalPost() {
        val body = """
              {
                  "receiverId": "bananasInPyjamas"
              }
        """.trimIndent()
        mockController.perform(
            MockMvcRequestBuilders
                .post("/interactions")
                .contentType(MediaType (MediaType.APPLICATION_JSON.type, MediaType.APPLICATION_JSON.subtype))
                .content(body)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
    }
}
