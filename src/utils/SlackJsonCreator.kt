package utils

object SlackJsonCreator {

    fun createDivider() = """
        {
			"type": "divider"
		}
    """.toJson()

    fun createPlainText(text: String) = """
        {
            "type": "plain_text",
            "text": "$text"
        }
    """.toJson()

    fun createMarkdownText(text: String) = """
        {
            "type": "mrkdwn",
            "text": "$text"
        }
    """.toJson()

    fun createInputBlock(blockId: String, label: String, placeholder: String, hint: String, optional: Boolean, multiline: Boolean = false) = """
        {
            "type": "input",
            "block_id": "$blockId",
            "label": $label,
            "element": {
                "type": "plain_text_input",
                "action_id": "action",
                "placeholder": $placeholder,
                "multiline": $multiline
            },
            "hint": $hint,
            "optional": $optional
        }
    """.toJson()

    fun createSelectBlock(
        blockId: String,
        label: String,
        placeholder: String,
        multiSelect: Boolean = false,
        options: String,
        hint: String = createPlainText(" "),
        optional: Boolean
    ) = """
        {
            "type": "input",
            "block_id": "$blockId",
            "label": $label,
            "element": {
                "type": "${if (multiSelect) "multi_static_select" else "static_select"}",
                "action_id": "action",
                "placeholder": $placeholder,
                "options": $options
            },
            "hint": $hint,
            "optional": $optional
        }
    """.toJson()

    fun createOption(text: String, value: String) = """
        {
            "text": ${createPlainText(text)},
            "value": "$value"
        }
    """.toJson()
}