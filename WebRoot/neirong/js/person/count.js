$(document).ready(function(e) {
    years = new Array();
    counts_zhi = new Array();
    counts_jian = new Array();
    $.post('../personJ/showCount', function(data) {
        $.each(data,function(i,bean){
            years[i]=bean.year;
            counts_zhi[i]=bean.count_zhi;
            counts_jian[i]=bean.count_jian;
            
        });
        showCount(years,counts_zhi,counts_jian);
    });

});
     
var showCount = function(years,counts_zhi,counts_jian) {
    var myChart = echarts.init(document.getElementById('main'));
    option = {

tooltip : {
trigger: 'axis',
axisPointer : {            // 坐标轴指示器，坐标轴触发有效
type : 'line'        // 默认为直线，可选为：'line' | 'shadow'
    
}
},
legend: {
    data:['直接介绍','间接介绍']
},
xAxis : [
{
type : 'category',
data : years,
axisLabel: {
    formatter: '{value}月'
}
}
],
yAxis : [
{
type : 'value',
axisLabel: {
    formatter: '{value}人'
}
}
],
series : [
{
name:'直接介绍',
type:'bar',
barCategoryGap: '80%',
data:counts_zhi
},
{
    name:'间接介绍',
    type:'bar',
    barCategoryGap: '80%',
    data:counts_jian
    }
]
};

    myChart.setOption(option);
   
};

