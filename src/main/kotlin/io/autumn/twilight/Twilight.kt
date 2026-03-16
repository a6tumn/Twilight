package io.autumn.twilight

import net.minecraft.resources.Identifier
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object Twilight {
	const val NAMESPACE = "twilight"
	val LOGGER: Logger? = LogManager.getLogger(NAMESPACE)

	fun namespaceAndPath(path: String): Identifier = Identifier.fromNamespaceAndPath(NAMESPACE, path)
}