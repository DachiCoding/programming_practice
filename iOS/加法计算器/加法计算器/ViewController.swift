//
//  ViewController.swift
//  加法计算器
//
//  Created by DACHI XU on 12/12/14.
//  Copyright (c) 2014 DACHI XU. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet var textOne: UITextField!
    @IBOutlet var textTwo: UITextField!
    @IBOutlet var resultLabel: UILabel!
    @IBAction func calculate() {
        var num1 = self.textOne.text.toInt()
        var num2 = self.textTwo.text.toInt()
        var resultNum = num1! + num2!
        var resultStr = String.convertFromStringInterpolationSegment(resultNum)
        self.resultLabel.text = resultStr
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

