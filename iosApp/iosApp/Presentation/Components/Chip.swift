//
//  Chip.swift
//  iosApp
//
//  Created by mac on 03/04/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct Chip: View {
    var label:String
    var body: some View {
        Text(label)
            .padding(.horizontal,12)
            .padding(.vertical,4)
            .foregroundColor(Color("ColorPrimary"))
            .background(Color.gray.opacity(0.2))
            .overlay(
                RoundedRectangle(cornerRadius: 8)
                    .stroke(Color("ColorPrimary"),lineWidth: 1)
            )
    }
}

#Preview {
    Chip(label:"Thrill")
}
