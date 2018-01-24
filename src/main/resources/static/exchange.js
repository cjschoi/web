
var infodata = {
    list:"",
    high:"",
    low:"",
    volume:"",
    base_volume:"",
    last:"",
    marketCurrency:"",
    baseCurrency:""
};

var tradinginfo = new Vue({
    el: '#trading-info',
    data:{
        List : infodata
    }

});



var app1 = new Vue({
    el: '#app1',
    methods: {
        getMessage: function () {
            axios.get('/getTradingInfoData')
                .then(function(response) {
                // JSON responses are automatically parsed.
                    console.log(response.data);
                    tradinginfo.List = response.data;
            }.bind(this))
                .catch(function(e) {
                    this.errors.push(e)
                });

        }
    }
});
