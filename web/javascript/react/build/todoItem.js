/*jshint quotmark:false */
/*jshint white:false */
/*jshint trailing:false */
/*jshint newcap:false */
/*global React */
var app = app || {};

(function () {
    'use strict';

    var ESCAPE_KEY = 27;
    var ENTER_KEY = 13;

    app.TodoItem = React.createClass({
        displayName: "TodoItem",

        handleSubmit: function (event) {
            var val = this.state.editText.trim();
            if (val) {
                this.props.onSave(val);
                this.setState({ editText: val });
            } else {
                this.props.onDestroy();
            }
        },

        handleEdit: function () {
            this.props.onEdit();
            this.setState({ editText: this.props.todo.title });
        },

        handleKeyDown: function (event) {
            if (event.which === ESCAPE_KEY) {
                this.setState({ editText: this.props.todo.title });
                this.props.onCancel(event);
            } else if (event.which === ENTER_KEY) {
                this.handleSubmit(event);
            }
        },

        handleChange: function (event) {
            if (this.proprs.editing) {
                this.setState({ editText: event.target.value });
            }
        },

        getInitialState: function () {
            return { editText: this.props.todo.title };
        },

        shouldComponentUpdate: function (nextProps, nextState) {
            return nextProps.todo !== this.props.todo || nextProps.editing !== this.props.editing || nextState.editText !== this.state.editText;
        },

        componentDidUpdate: function (prevProps) {
            if (!prevProps.editing && this.props.editing) {
                var node = React.findDOMNode(this.refs.editField);
                node.focus();
                node.setSelectionRange(node.value.length, node.value.length);
            }
        },

        render: function () {
            return React.createElement(
                "li",
                { className: classNames({
                        completed: this.props.todo.completed,
                        editing: this.props.editing
                    }) },
                React.createElement(
                    "div",
                    { className: "view" },
                    React.createElement("input", {
                        className: "toggle",
                        type: "checkbox",
                        checked: this.props.todo.completed,
                        onChange: this.props.onToggle
                    }),
                    React.createElement(
                        "label",
                        { onDoubleClick: this.handleEdit },
                        this.props.todo.title
                    ),
                    React.createElement("button", { className: "destroy", onClick: this.props.onDestroy })
                ),
                React.createElement("input", {
                    ref: "editField",
                    className: "edit",
                    value: this.state.editText,
                    onBlur: this.handleSubmit,
                    onChange: this.handleChange,
                    onKeyDown: this.handleKeyDown
                })
            );
        }
    });
})();