
Polymer({

    is: "meal-detail",

    properties: {

    },

    ready: function() {
    },

    loadMeal: function(id) {
        this.$.additionRequest.params = {
            mealID: id
        };
        this.$.additionRequest.generateRequest();
    },

    _handleMealResponse: function (request) {
        this.set("addition", request.detail.response);
    }

});