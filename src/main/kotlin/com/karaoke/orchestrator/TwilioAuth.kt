package com.karaoke.orchestrator

abstract class TwilioAuth() {
  companion object {
    val ACCOUNT_SID: String = System.getenv("ACCOUNT_SID")
    val AUTH_TOKEN: String = System.getenv("AUTH_TOKEN")
    val FROM_NUMBER: String = System.getenv("FROM_NUMBER")
  }
}
