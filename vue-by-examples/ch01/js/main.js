const app = new Vue({
    el: '#app',

    data: {
        message: 'Hello!',
        shirtPrice: 25,
        hatPrice: 10,
        currency: '$',
        salesTax: 16,
    },

    computed: {
        shirtCost() {
            return this.addCurrency(
                this.calculateSalesTax(this.shirtPrice
                )
            );
        },

        hatCost() {
            return this.addCurrency(
                this.calculateSalesTax(
                    this.hatPrice
                )
            );
        },

    },

    methods: {
        calculateSalesTax(price) {
            return parseFloat(
            Math.round((this.salesTax / 100) * price)
            + price).toFixed(2);
        },

        addCurrency(price) {
            return this.currency + price;
        }
    },


});

