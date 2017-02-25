package xpay

trait XpayToPayDAdapter {

    self: PayD with Xpay =>
        def getCustCardNo : String            = getCreditCardNo : String
        def setCustCardNo(custCardNo: String) = setCreditCardNo(custCardNo: String)
        def getCardOwnerName: String          = getCustomerName : String
        def setCardOwnerName(cardOwnerName: String) = setCustomerName(cardOwnerName: String)
        def getCardExpMonthDate : String = getCardExpMonth : String
        def setCardExpMonthDate(cardExpMonthDate: String) = setCardExpMonth(cardExpMonthDate: String)
        def getCVVNo : Integer = getCardCVVNo :

    // PayD

//    def getCVVNo: Integer
//
//    def setCVVNo(cVVNo: Integer)
//
//    def getTotalAmount: Double
//
//    def setTotalAmount(totalAmount: Double)

    // Xpay

//    def getCardExpYear: String
//
//    def setCardExpYear(cardExpYear: String)
//
//    def getCardCVVNo: Short
//
//    def setCardCVVNo(cardCVVNo: Short)
//
//    def getAmount: Double
//
//    def setAmount(amount: Double)
}
