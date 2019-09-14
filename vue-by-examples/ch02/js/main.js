const app = new Vue({
    el: '#app',

    data: {
        imageSource: 'http://via.placeholder.com/350x150',
        isVisible: false,
        people: [
            {name: 'Morales Ochoa', email: 'moralesochoa@savvy.com', balance: 2570.32, registered: '', isActive: true},
            {name: 'Tyson Beard', email: 'tysonbeard@savvy.com', balance: 1892.1, registered: '', isActive: true},
            {name: 'Hawkins Gibbs', email: 'hawkinsgibbs@savvy.com', balance: 3423.69, registered: '', isActive: false},
            {name: 'Conley Boyle', email: 'conleyboyle@savvy.com', balance: 3277.41, registered: '', isActive: true},
            {name: 'Joy Mosley', email: 'joymosley@savvy.com', balance: 2180.15, registered: '', isActive: true},
        ],
        currency: '$',
        filterField: 'name',
        filterQuery: '',
        filterUserState: true,
    },

    computed: {
    },

    methods: {
        activeStatus(person) {
            return (person.isActive) ? 'Active' : 'Inactive'
        },

        formatBalance(balance) {
            return this.currency + balance.toFixed(2);
        },
        
        formatDate(date) {
            return new Date().toLocaleString('en-US')
        },

        filterRow(person) {
            let result = true;

            if(this.filterField === 'isActive') {
                result = this.filterUserState === person.isActive;
            } else {
                let query = this.filterQuery.toLowerCase();
                let field = person[this.filterField].toString().toLowerCase();
                result = field.includes(query);
            }
            return result;
        },
    },


});

