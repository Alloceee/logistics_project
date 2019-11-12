const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

const toQueryString = paramObj =>{
  let str = "";
  Object.keys(paramObj).map((key)=>{{
    str = str.concat(key).concat("=").concat(paramObj[key]).concat("&");
  }});
  if (str.endsWith("&")) str = str.substring(0, str.length -1 );
  return str;
}
module.exports = {
  formatTime: formatTime,
  toQueryString: toQueryString
}
