package com.karaoke.orchestrator

import com.twilio.Twilio;
import com.twilio.http.HttpMethod;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

import java.net.URI;

abstract class Caller() {
  companion object {
    fun ring(number: PhoneNumber): Call {
      Twilio.init(TwilioAuth.ACCOUNT_SID, TwilioAuth.AUTH_TOKEN)
      return Call.creator(
        number,
        PhoneNumber(TwilioAuth.FROM_NUMBER),
        URI.create("http://demo.twilio.com/docs/voice.xml")
      ).create()
    }
  }
}
