const superagent = require('superagent');
const assert = require('assert');

// Task 1
superagent
  .get('https://pro-api.coinmarketcap.com/v1/cryptocurrency/map')
  .query({ symbol: 'BTC,USDT,ETH' })
  .set('X-CMC_PRO_API_KEY', 'c46a40fe-3036-471d-97de-f0b277938fea')
  .set('Accept', 'application/json')
  .set('Accept', 'application/gzip')
  .end((err, res) => {
    console.log(res.body.data[0].id);
    console.log(res.body.data[1].id);
    console.log(res.body.data[2].id);
    assert.ifError(err);
    assert.equal(res.status, 200);
  });

// Task 1 Conversion 1
superagent
  .get('https://pro-api.coinmarketcap.com/v1/tools/price-conversion')
  .query({ id: 1, amount: 50, convert: 'BOB' })
  .set('X-CMC_PRO_API_KEY', 'c46a40fe-3036-471d-97de-f0b277938fea')
  .set('Accept', 'application/json')
  .set('Accept', 'application/gzip')
  .end((err, res) => {
    console.log('BOB Price conversion :' + res.body.data.quote.BOB.price)
    assert.ifError(err);
    assert.equal(res.status, 200);
    assert.equal(res.body.data.symbol, 'BTC');
  });

// Task 1 Conversion 2
superagent
  .get('https://pro-api.coinmarketcap.com/v1/tools/price-conversion')
  .query({ id: 1027, amount: 50, convert: 'BOB' })
  .set('X-CMC_PRO_API_KEY', 'c46a40fe-3036-471d-97de-f0b277938fea')
  .set('Accept', 'application/json')
  .set('Accept', 'application/gzip')
  .end((err, res) => {
    console.log('BOB Price conversion :' + res.body.data.quote.BOB.price)
    assert.ifError(err);
    assert.equal(res.status, 200);
    assert.equal(res.body.data.symbol, 'ETH');
  });

// Task 1 Conversion 3
superagent
  .get('https://pro-api.coinmarketcap.com/v1/tools/price-conversion')
  .query({ id: 825, amount: 50, convert: 'BOB' })
  .set('X-CMC_PRO_API_KEY', 'c46a40fe-3036-471d-97de-f0b277938fea')
  .set('Accept', 'application/json')
  .set('Accept', 'application/gzip')
  .end((err, res) => {
    console.log('BOB Price conversion :' + res.body.data.quote.BOB.price)
    assert.ifError(err);
    assert.equal(res.status, 200);
    assert.equal(res.body.data.symbol, 'USDT');
  });

// Task 2
superagent
  .get('https://pro-api.coinmarketcap.com/v1/cryptocurrency/info')
  .query({ id: '1027' })
  .set('X-CMC_PRO_API_KEY', 'c46a40fe-3036-471d-97de-f0b277938fea')
  .set('Accept', 'application/json')
  .set('Accept', 'application/gzip')
  .end((err, res) => {
    console.log(JSON.stringify(res.body));
    assert.ifError(err);
    assert.equal(res.status, 200);
    assert.equal(res.body.data['1027'].platform, null);
    assert.equal(res.body.data['1027'].date_added, '2015-08-07T00:00:00.000Z');
    assert.equal(res.body.data['1027'].tags, 'mineable');
    assert.equal(res.body.data['1027'].symbol, 'ETH');
    assert.equal(res.body.data['1027'].logo, 'https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png');
    assert.equal(res.body.data['1027'].urls.technical_doc, 'https://github.com/ethereum/wiki/wiki/White-Paper');
  });
