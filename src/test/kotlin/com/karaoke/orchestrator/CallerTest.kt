package com.karaoke.orchestrator

import com.twilio.exception.ApiException
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.boot.test.context.SpringBootTest
import com.twilio.type.PhoneNumber
import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.assertThrows
import java.lang.RuntimeException

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CallerTest() {
  @Test
  fun testSuccessCallCreator() = assertEquals(Caller.ring(PhoneNumber("+15005550005")).status.toString(), "queued") // Valid Twilio test destination number

  @Test(expected = com.twilio.exception.ApiException::class)
  fun testInvalidCallCreator() {
      Caller.ring(PhoneNumber("+15005550001")).status.toString() // Invalid twilio test phone number
  }

  @Test(expected = com.twilio.exception.ApiException::class)
  fun testNoRouteCallCreator() {
    Caller.ring(PhoneNumber("+15005550002")).status.toString() // Valid Twilio test destination number
  }

  @Test(expected = com.twilio.exception.ApiException::class)
  fun testNoInternationalCallCreator() {
      Caller.ring(PhoneNumber("+15005550003")).status.toString() // Valid Twilio test destination number
  }

  @Test(expected = com.twilio.exception.ApiException::class)
  fun testBlockedCallCreator() {
    Caller.ring(PhoneNumber("+15005550004")).status.toString() // Valid Twilio test destination number
  }
}
