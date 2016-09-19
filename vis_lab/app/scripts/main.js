var svg = d3.select('div#chart').append('svg');

svg.attr('width',window.innerWidth*0.5);
svg.attr('height',window.innerHeight*0.5);

svg.append('text')
    .text('A picture!')
    .attr({
      x: 150,
      y: 150,
      'text-anchor': 'start'
});
