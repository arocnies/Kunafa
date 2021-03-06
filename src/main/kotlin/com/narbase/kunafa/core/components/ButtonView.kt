package com.narbase.kunafa.core.components

import com.narbase.kunafa.core.components.layout.Container
import com.narbase.kunafa.core.dimensions.CalculatedDimension
import com.narbase.kunafa.core.dimensions.Dimension
import com.narbase.kunafa.core.dimensions.DynamicDimension
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLSpanElement
import org.w3c.dom.events.Event
import kotlin.browser.document

/**
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2013] - [2018] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 10/15/17.
 */
class ButtonView(parent: Container? = null) : View(parent) {
//    override val element: HTMLElement = document.createElement("button") as HTMLButtonElement

    val button by lazy {
        val b = document.createElement("button") as HTMLButtonElement
        element.append(b)
        return@lazy b
    }

    override var onClick: ((Event) -> Unit)? = null
        set(value) {
            field = value
            button.onclick = onClick
        }

    override fun updateContentWidth() {
        super.updateContentWidth()
        if (width is DynamicDimension) {
            (width as? DynamicDimension)?.configure(button, Dimension.Type.width)
        } else (width as? CalculatedDimension)?.let {
            button.style.width = "${it.pixels}px"
            button.style.minWidth = "${it.pixels}px"
        }
    }

    override fun updateContentHeight() {
        super.updateContentHeight()
        if (height is DynamicDimension) {
            (height as? DynamicDimension)?.configure(button, Dimension.Type.height)
        } else (height as? CalculatedDimension)?.let {
            button.style.height = "${it.pixels}px"
            button.style.minHeight = "${it.pixels}px"
        }
    }

}