package in.milcom.example.async.grails

import static grails.async.Promises.*

class AsyncController {

    def index() { 

    }

    def context(Long loops) {
        log.info("Inside action: context.")
    	if(loops < 1000) {
            log.info("Done Quickly")
    		render "Done Quickly"
    	} else {
    		def ctx = startAsync()
    		ctx.start {
    			Thread.sleep(loops)
                log.info("Long Running")	
    			render "Long Running"
    			ctx.complete()
    		}
    	}
    }

    def promiseTask(Long loops) {
        log.info("Inside action: task")
        if(loops < 1000) {
            render "Done Quickly"
        } else{
            task {
                Thread.sleep(2000)
                render "Finished running the task using promise."        
            }    
        }            
    }
}
