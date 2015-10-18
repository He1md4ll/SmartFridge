Polymer({

    is: "main-app",

    properties: {
        selectedPage: {
            type: Number,
            value: 0,
            observer: "_selectedPageChanged"
        },
        selectedMeal: {
            type: Object,
            value: null
        }
    },

    ready: function () {
        this.showMealList();
    },

    menuIcon: function (selectedMeal) {
        return selectedMeal ? "arrow-back" : "menu";
    },

    menuButtonClicked: function () {
        if (!this.selectedMeal)
            this.$.drawer.openDrawer();
        else
            this.showMealList();
    },

    showMealList: function () {
        this.set("selectedMeal", null);
        this.set("title", "Meals");
        this.set("selectedPage", 0);
        this.$.mealList.loadMeals();
    },

    showMealDetail: function (meal) {
        this.$.drawer.closeDrawer();
        this.set("selectedMeal", meal);
        this.set("title", meal.name);
        this.set("selectedPage", 2);
        this.$.mealDetail.loadMeal(meal.id);
    },

    addMeal: function () {
        this.$.addDialog.showDialog(this.selectedMeal.id);
    },

    _mealAdded: function (event) {
        this.$.addDialog.showDialog(event.detail.id);
    },

    _mealSelected: function (event) {
        this.showMealDetail(event.detail.meal);
    },

    _selectedPageChanged: function(newValue, oldValue) {
        if (newValue < 2)
            this.set("selectedMeal", null);
        if (newValue == 1) {
            this.set("title", "Groceries");
            this.$.groceryList.loadGroceries();
        }
        this.$.drawer.closeDrawer();
    }

});