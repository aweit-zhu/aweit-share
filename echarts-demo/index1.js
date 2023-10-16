var dom = document.getElementById('chart-container');
var myChart = echarts.init(dom);
var option;

option = {
  xAxis: {
    type: 'category',
    data: []
  },
  yAxis: {
    type: 'value',
  },
  tooltip: {
    trigger: 'item',
  },
  series: [
    {
      data: [],
      type: 'bar',
      showBackground: true,
      backgroundStyle: {
        color: 'rgba(180, 180, 180, 0.2)'
      }
    }
  ]
};


if (option && typeof option === 'object') {
  myChart.setOption(option);
}

window.addEventListener('resize', myChart.resize);

// AJAX
myChart.showLoading();
$.get('data.json').done(function(data) {
  myChart.hideLoading();
  myChart.setOption({
    xAxis: {
      data: data.categories
    },
    series: [
      {
        data: data.data
      }
    ]
  });
});

