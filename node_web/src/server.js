var express = require('express');
var webpack = require('webpack');
var webpackDevMiddleware = require('webpack-dev-middleware');
var webpackConfig = require('../webpack.config');
var badyParser = require("body-parser");

var app = express();
app.set('port', (process.env.PORT || 3000));

app.use('/static', express.static('dist'));
app.use(badyParser.json());
app.use(badyParser.urlencoded({ extended: true }));
app.use(webpackDevMiddleware(webpack(webpackConfig)));


app.get('/', function (req, res, next) {
    res.send('TecnoWEB');
});


app.listen(app.get('port'), () => {
    console.log('Servidor activo 1');
})
