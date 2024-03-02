//
//  TextToSpeech.swift
//  iosApp
//
//  Created by Tomi EEDF on 27/02/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import AVFoundation

struct TextToSpeech{
    
    private let synthesizer = AVSpeechSynthesizer()
    
    func speak(text: String , language : String){
        let utterance = AVSpeechUtterance(string: text)
        utterance.voice = AVSpeechSynthesisVoice(language: language)
        utterance.volume = 1
        synthesizer.speak(utterance)
     }
 }
