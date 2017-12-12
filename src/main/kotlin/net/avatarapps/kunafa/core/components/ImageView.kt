package net.avatarapps.kunafa.core.components

import net.avatarapps.kunafa.core.components.layout.Container
import net.avatarapps.kunafa.core.dimensions.CalculatedDimension
import net.avatarapps.kunafa.core.dimensions.Dimension
import net.avatarapps.kunafa.core.dimensions.DynamicDimension
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLImageElement
import org.w3c.dom.events.Event
import kotlin.browser.document

/**
 * AVATAR APPS CONFIDENTIAL
 * ______________________________
 * [2013] - [2017] Avatar Apps
 * All Rights Reserved.
 * Created by islam
 * On: 10/15/17.
 */
class ImageView(parent: Container? = null) : View(parent) {
//    override val element: HTMLElement = document.createElement("button") as HTMLButtonElement

    val img by lazy {
        val b = document.createElement("img") as HTMLImageElement
        element.append(b)
        return@lazy b
    }

    override var onClick: ((Event) -> Unit)? = null
        set(value) {
            field = value
            img.onclick = onClick
        }

    override fun updateContentWidth() {
        super.updateContentWidth()
        if (width is DynamicDimension) {
            (width as? DynamicDimension)?.configure(img, Dimension.Type.width)
        } else (width as? CalculatedDimension)?.let {
            img.style.width = "${it.pixels}px"
            img.style.minWidth = "${it.pixels}px"
        }
    }

    override fun updateContentHeight() {
        super.updateContentHeight()
        if (height is DynamicDimension) {
            (height as? DynamicDimension)?.configure(img, Dimension.Type.height)
        } else (height as? CalculatedDimension)?.let {
            img.style.height = "${it.pixels}px"
            img.style.minHeight = "${it.pixels}px"
        }
    }

}