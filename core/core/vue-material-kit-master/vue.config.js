module.exports = {
  css: {
    loaderOptions: {
      css: {
        sourceMap: process.env.NODE_ENV !== "production" ? true : false
      }
    }
  },
  devServer:{
    proxy: {
      '/*':{
        target:'http://localhost:8080',
        changeOrigin: true
      }
    }
  }


};
