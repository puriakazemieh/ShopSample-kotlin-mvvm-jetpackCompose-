package com.kazemieh.www.shop.util

import android.app.Activity
import android.util.Log
import com.kazemieh.www.shop.util.Constants.ZARINPAL_MERCHANT_ID
import com.zarinpal.ZarinPalBillingClient
import com.zarinpal.billing.purchase.Purchase
import com.zarinpal.client.BillingClientStateListener
import com.zarinpal.client.ClientState
import com.zarinpal.provider.core.future.FutureCompletionListener
import com.zarinpal.provider.core.future.TaskResult
import com.zarinpal.provider.model.response.Receipt

object ZarinpalPurchase {

    private val stateListener = object : BillingClientStateListener {
        override fun onClientServiceDisconnected() {

        }

        override fun onClientSetupFinished(state: ClientState) {

        }

    }

    fun purchase(
        activity: Activity,
        amount: Long,
        description: String,
        onPurchaseCompleted: (String) -> Unit
    ) {

        val client = ZarinPalBillingClient.newBuilder(activity)
            .enableShowInvoice()
            .setListener(stateListener)
            .build()

        val purchase = Purchase.newBuilder()
            .asPaymentRequest(ZARINPAL_MERCHANT_ID, amount, "my url ", description).build()

        client.launchBillingFlow(purchase, object : FutureCompletionListener<Receipt> {
            override fun onComplete(task: TaskResult<Receipt>) {
                if (task.isSuccess) {
                    val receipt = task.success
                    receipt?.transactionID?.let {
                        Log.d("949494", " $it ")
                        onPurchaseCompleted(it)
                    }
                } else {
                    task.failure?.printStackTrace()
                }
            }

        })

    }


    fun fakePurchase(
        activity: Activity,
        amount: Long,
        description: String,
        onPurchaseCompleted: (String) -> Unit
    ) {
        Thread.sleep(1000)
        onPurchaseCompleted(generateRandomString(8))
    }

    private fun generateRandomString(length: Int): String {
        val chars = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        return List(length) { chars.random() }.joinToString("")
    }
}