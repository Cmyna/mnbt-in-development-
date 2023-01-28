package com.myna.mnbt.converter

import com.myna.mnbt.annotation.MapTo
import java.util.*

fun nestCIntent(parents: Deque<Any>, ignoreTypeToken:Boolean): RecordParents {
    return object: RecordParents, ToValueTypeToken {
        override val parents: Deque<Any> = parents
        override val ignore: Boolean = ignoreTypeToken
    }
}

fun converterCallerIntent(ignoreTypeToken:Boolean = false): ConverterCallerIntent {
    return object: ToValueTypeToken,RecordParents {
        override val parents: Deque<Any> = ArrayDeque()
        override val ignore: Boolean = ignoreTypeToken
    }
}

fun conversionWithStartAtIntent(parents: Deque<Any>, ignoreTypeToken:Boolean, annotation: MapTo): ConverterCallerIntent {
    return object: ToValueTypeToken,StartAt,RecordParents {
        override val parents: Deque<Any> = ArrayDeque()
        override val ignore = ignoreTypeToken
        override val path = annotation.path
        override val tagTypeId = annotation.typeId
    }
}