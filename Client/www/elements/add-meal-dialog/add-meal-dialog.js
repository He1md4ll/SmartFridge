var DAYS = [ "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY" ];

Polymer({

    is: "add-meal-dialog",

    attached: function() {
        //this.$.dialog.open();

    },

    showDialog: function(id) {
        this.id = id;
        this.$.days.selected = 0;
        this.$.time.selected = "BREAKFAST";
        this.$.dialog.open();
    },

    addMeal: function() {

        this.$.mealRequest.params = {
            day: DAYS[this.$.days.selected],
            mealTime: this.$.time.selected,
            mealID: this.id
        };

        this.$.mealRequest.generateRequest();

    },

    _handleMealResponse: function(request) {
        console.log(request.detail.response);
    }

});