import React, { Component, PropTypes } from 'react'

export default class Canvas extends Component {
    static propTypes = {
    }

    constructor(props){
        super(props);
        this.state = {
            context: null,
            canvas: null
        }
    }

    drawTextExample(){
        var canvas = this.state.canvas;
        if(canvas){
          var context = this.state.context;
          if(context){
            context.font = '38pt Arial';
            context.fillStyle = 'cornflowerblue';
            context.strokeStyle = 'blue';
            context.fillText('Hello Canvas',canvas.width/2-150,canvas.height/2+15);
            context.strokeText('Hello Canvas',canvas.width/2-150,canvas.height/2+15);
          }
        }
    }

    drawCircle(){
        const ctx = this.state.context;
        const cvs = this.state.canvas;
        ctx.beginPath();
        ctx.arc(cvs.width/2,cvs.height/2,this.state.radius,0,Math.PI*2,true);
        ctx.stroke();
    }

    drawNumerals(){
        const ctx = this.state.context;
        const cvs = this.state.canvas;
        const HAND_RADIUS = this.state.handRadius;
        const FONT_HEIGHT = this.state.fontHeight;
        var numerals = [];
        for(let i = 0; i < 12; i++){
            numerals.push(i+1);
        }
        var angle = 0;
        var numeralWidth = 0;
        
        numerals.forEach(function(numeral){
            angle = Math.PI/6*(numeral-3);
            numeralWidth = ctx.measureText(numeral).width;
            ctx.fillText(numeral,
                cvs.width/2 + Math.cos(angle)*(HAND_RADIUS)-numeralWidth/2,
                cvs.height/2 + Math.sin(angle)*(HAND_RADIUS)+FONT_HEIGHT/3);
        });
    }

    drawCenter(){
        const ctx = this.state.context;
        const cvs = this.state.canvas;
        ctx.beginPath();
        ctx.arc(cvs.width/2,cvs.hegiht/2,5,0,Math.PI*2,true);
        ctx.fill();
    }

    drawHand(loc,isHour){
        var angle = (Math.PI*2)*(loc/60)-Math.PI/2;
        var handRadius = isHour?this.state.handRadius-this.state.handTruncation-this.state.hourHandTruncation:this.state.radius-this.state.handTruncation;
        const ctx = this.state.context;
        const cvs = this.state.canvas;
        ctx.moveTo(cvs.width/2,cvs.hegiht/2);
        ctx.lineTo(cvs.width/2+Math.cos(angle)*handRadius,cvs.height/2+Math.sin(angle)*handRadius);
        ctx.stroke();
    }

    drawHands(){
        var date = new Date;
        var hour = date.getHours();
        hour = hour > 12 ? hour - 12 : hour;
        this.drawHand(hour*5+(date.getMinutes()/60)*5,true,0.5);
        this.drawHand(date.getMinutes(),false,0.5);
        this.drawHand(date.getSeconds(),false,0.2);
    }

    drawClock(){
        this.state.context.clearRect(0,0,this.state.canvas.width,this.state.canvas.height);
        this.drawCircle();
        this.drawCenter();
        this.drawHands();
        this.drawNumerals();
    }

    componentDidMount(){
        this.state.canvas = document.getElementById("canvas"); 
        this.state.context = this.state.canvas.getContext('2d');
        this.state.fontHeight = 15;
        this.state.margin = 100;
        this.state.handTruncation = canvas.width/25;
        this.state.hourHandTruncation = canvas.width/10;
        this.state.numeralSpacing = 20;
        this.state.radius = canvas.width/2 - this.state.margin;
        this.state.handRadius = this.state.radius + this.state.numeralSpacing;
        this.state.context.font = this.state.fontHeight+'px Arial';
        this.drawClock = this.drawClock.bind(this);
        this.loop = setInterval(this.drawClock,1000);
    }

    render(){
        return (
        <div>
            <h1>I am a canvas example page</h1>
            <canvas id="canvas"></canvas>
        </div>
        );
    }
}




