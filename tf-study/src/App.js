import React, { Component } from 'react';
import * as tf from '@tensorflow/tfjs';
import logo from './logo.svg';
import './App.css';

class App extends Component {

  componentDidMount() {
    // this.runTensorFlow();
    this.fitCurve();
  }

  runTensorFlow = () => {
    // const model = tf.sequential();
    // model.add(tf.layers.dense({units: 1, inputShape: [1]}));
    // model.compile({
    //   loss: 'meanSquaredError', 
    //   optimizer: 'sgd'
    // });
    // const xs = tf.tensor2d([1,2,3,4],[4,1]);
    // const ys = tf.tensor2d([1,3,5,7],[4,1]);

    // model.fit(xs,ys).then(() => {
    //   model.predict(tf.tensor2d([5],[1,1])).print();
    // })

    //TENSORS
    const shape = [2,3];
    const a = tf.tensor([1.0,2.0,3.0,10.0,20.0,30.0], shape);
    a.print();

    const b = tf.tensor([[1.0,2.0,3.0],[10.0,20.0,30.0]]);
    b.print();

    const c = tf.tensor2d([[1.0,2.0,3.0],[10.0,20.0,30.0]]);
    c.print();

    //VARIABLES
    const initialValues = tf.zeros([5]);
    const biases = tf.variable(initialValues);
    biases.print();
    const updatedValues = tf.tensor1d([0,1,0,1,0]);
    biases.assign(updatedValues);
    biases.print();

    //OPERATIONS
    const d = tf.tensor2d([[1.0, 2.0],[3.0, 4.0]]);
    const d_squared = d.square();
    d_squared.print();
    const e = tf.tensor2d([[1.0,2.0],[3.0,4.0]]);
    const f = tf.tensor2d([[5.0,6.0],[7.0,8.0]]);
    const e_plus_f = e.add(f);
    e_plus_f.print();
    const sq_sum = e.add(f).square();
    sq_sum.print();

    //MODELs and LAYERs
    const result = this.predict(2);
    result.print();
    const rnn = tf.layers.simpleRNN({units:8,returnSequences:true});
    const input = tf.input({shape:[10,20]});
    const output = rnn.apply(input);
    console.log(JSON.stringify(output.shape));
  }

  predict = (input) => {
    const a = tf.scalar(2);
    const b = tf.scalar(4);
    const c = tf.scalar(8);
    return tf.tidy(() => {
      const x = tf.scalar(input);
      const ax2 = a.mul(x.square());
      const bx = b.mul(x);
      const y = ax2.add(bx).add(c);
      return y;
    })
  }

  fitCurve = () => {
  }

  curvePredict = (x) => {
    //set up variables
    const a = tf.variable(tf.scalar(Math.random()));
    const b = tf.variable(tf.scalar(Math.random()));
    const c = tf.variable(tf.scalar(Math.random()));
    const d = tf.variable(tf.scalar(Math.random()));

    return tf.tidy(() => {
      return a.mul(x.pow(tf.scalar(3)))
      .add(b.mul(x.square()))
      .add(c.mul(x))
      .add(d);
    });
  }

  loss = (predictions, labels) => {
    const meanSquaredError = predictions.sub(labels).square().mean();
    return meanSquaredError;
  }

  train = (xs, ys, numIterations = 75) => {
    const learningRate = 0.5;
    const optimizer = tf.train.sgd(learningRate);

    for(let iter = 0; iter < numIterations; iter++) {
      optimizer.minimize(() => {
        const predsYs = this.curvePredict(xs);
        return this.loss(predsYs, ys);
      })
    }
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      </div>
    );
  }
}

export default App;
