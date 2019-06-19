package com.example.espressokata.util


import androidx.test.espresso.IdlingResource

import java.util.concurrent.atomic.AtomicInteger

import androidx.core.util.Preconditions.checkNotNull

class SimpleCountingIdlingResource(resourceName: String) : IdlingResource {

    private val resourceName: String

    private val counter = AtomicInteger(0)

    @Volatile
    private var resourceCallback: IdlingResource.ResourceCallback? = null

    init {
        this.resourceName = checkNotNull(resourceName)
    }

    override fun getName(): String {
        return resourceName
    }

    override fun isIdleNow(): Boolean {
        return counter.get() == 0
    }

    override fun registerIdleTransitionCallback(resourceCallback: IdlingResource.ResourceCallback) {
        this.resourceCallback = resourceCallback
    }

    fun increment() {
        counter.getAndIncrement()
    }

    fun decrement() {
        val counterVal = counter.decrementAndGet()
        if (counterVal == 0) {
            if (null != resourceCallback) {
                resourceCallback!!.onTransitionToIdle()
            }
        }

        if (counterVal < 0) {
            throw IllegalArgumentException("Counter has been corrupted!")
        }
    }
}
