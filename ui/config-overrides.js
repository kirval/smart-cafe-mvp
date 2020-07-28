// config-overrides.js
const { override } = require('customize-cra');
const dotenv = require('dotenv');

const findWebpackPlugin = (plugins, pluginName) =>
  plugins.find((plugin) => plugin.constructor.name === pluginName);

const overrideProcessEnv = (value) => (config) => {
  const plugin = findWebpackPlugin(config.plugins, 'DefinePlugin');
  const processEnv = plugin.definitions['process.env'] || {};
  const env = dotenv.config().parsed;
  const envKeys = Object.keys(env).reduce((prev, next) => {
    prev[next] = JSON.stringify(env[next]);
    return prev;
  }, {});

  plugin.definitions['process.env'] = {
    ...processEnv,
    ...envKeys,
    ...value,
  };

  return config;
};

module.exports = (webpack, ...args) => {
  webpack.plugins.pop();
  const overridenConf = override(
    overrideProcessEnv({
      VERSION: JSON.stringify(require('./package.json').version),
    })
  )(webpack, ...args);
  return overridenConf;
};
