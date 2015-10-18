Polymer({

    is: "meal-list",

    ready: function () {

    },

    loadMeals: function () {
        this.$.mealsRequest.generateRequest();
    },

    _handleMealsResponse: function (request) {
        this.set("meals", request.detail.response);
    },

    selectMeal: function (evt) {
        this.fire("meal-selected", {meal: evt.model.item});
    },

    addMeal: function (evt) {
        evt.stopImmediatePropagation();
        var id = evt.model.item.id;
        this.fire("meal-added", {id: id});
    }

});