Polymer({

    is: "grocery-list",

    ready: function () {

    },

    loadGroceries: function () {
        this.$.groceryRequest.generateRequest();
    },

    _handleGroceriesResponse: function (request) {
        this.set("groceries", request.detail.response);
    }

});