package observer

class SMSUsers(s: Subject, msg: String) extends Observer {

    def update(desc: String) {
        println(msg)
        println(desc)
        println("-"*40)
    }

    def subscribe() {
        s.subscribeObserver(this)
    }

    def unSubscribe() {
        s.unSubscribeObserver(this)
    }
}
