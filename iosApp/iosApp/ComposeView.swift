import Foundation
import shared
import SwiftUI

struct ComposeView: UIViewControllerRepresentable {
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
    }
    
    func makeUIViewController(context: Context) -> some UIViewController {
       Main_iosKt.MainViewController()
    }
}
