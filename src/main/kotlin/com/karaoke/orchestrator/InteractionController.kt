package com.karaoke.orchestrator

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger

@RestController
class InteractionController {
    companion object {
        val log = Logger.getLogger("InteractionsLogger")
    }

    @RequestMapping("/interactions", method = [RequestMethod.POST])
    // receiverId kept as a String, for it can be a uuid, as far as I am concerned
    fun create(@RequestBody receiver: Receiver) =
        log.info("Incoming receiver interaction -> $receiver")
}
