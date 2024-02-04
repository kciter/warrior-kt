package app.warriorkt.core

object LogQueue {
  private var messages: MutableList<String> = mutableListOf()

  fun add(message: String) {
    messages.add(message)
  }

  fun addAll(messages: List<String>) {
    this.messages.addAll(messages)
  }

  fun dequeue(): String? {
    if (messages.size > 0) {
      return messages.removeAt(0)
    }

    return null
  }

  fun clear() {
    messages.clear()
  }
}
