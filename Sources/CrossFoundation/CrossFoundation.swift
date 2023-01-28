import Foundation

extension String {
    /// Sets the cell contents to the given span, either by truncating or padding it out.
    public func pad(to cellSpan: Int, with padding: String = " ", rightAlign: Bool = false) -> String {
        var cell = self
        while cell.count > cellSpan {
            cell = String(cell.dropLast())
        }
        while cell.count < cellSpan {
            if rightAlign {
                cell = padding + cell
            } else {
                cell = cell + padding
            }
        }
        return cell
    }
}

public extension Double {
    // Kotlin:  Unresolved reference: Range
//    public static func random(in range: Range<Double>) -> Double {
//        return Random().randomDouble()
//    }
}



// MARK: Utilities

/// Output a debugging statement to the console.
public func dbg(_ value: String) {
    #if SKIP
    System.out.println("DEBUG Kotlin: \(value)")
    #else
    print("DEBUG Swift: \(value)")
    #endif
}


//
//  WIP:
// ===============
//  NSData
//  NSDate
//  NSURL
//  NSUUID
//  NSProcessInfo
//  NSFileManager
//
//  TODO:
// ===============
//  NSBundle
//  NSLocale
//  NSCache
//  NSCalendar
//  NSCalendarDate
//  NSLock?
//  NSFileHandle
//  NSFormatter
//  NSIndexPath
//  NSIndexSet
//  NSJSONSerialization
//  NSOperation
//  NSProgress
//  NSRegularExpression
//  NSRunLoop
//  NSScanner
//  NSFileWrapper
//  NSExpression
//  NSPredicate
//  NSPropertyList
//  NSStream
//  NSTask
//  NSThread
//  NSTimeZone
//  NSTimer
//  NSURLSession
//  NSUndoManager
//  NSUserDefaults
//
//  Collections:
// ===============
//  NSArray
//  NSSet
//  NSDictionary
//  NSMapTable
//  NSOrderedSet
//  NSPointerArray
//
//  Built-in:
// ===============
//  NSNull
//  NSString
//  NSDecimal
//  NSDecimalNumber
//  NSError
//  NSException
//  NSCoder
//  NSDebug
//  NSRange
//  NSValue
//
//  Unavailable:
// ===============
//
//  NSObjCRuntime
//  NSProxy
//  NSObject
//  NSInvocation
//  NSZone
//
//  Remaining:
// ===============
//
//  FoundationErrors
//  FoundationLegacySwiftCompatibility
//  NSAffineTransform
//  NSAppleEventDescriptor
//  NSAppleEventManager
//  NSAppleScript
//  NSArchiver
//  NSAttributedString
//  NSAutoreleasePool
//  NSBackgroundActivityScheduler
//  NSByteCountFormatter
//  NSByteOrder
//  NSCharacterSet
//  NSClassDescription
//  NSComparisonPredicate
//  NSCompoundPredicate
//  NSConnection
//  NSDateComponentsFormatter
//  NSDateFormatter
//  NSDateInterval
//  NSDateIntervalFormatter
//  NSDistantObject
//  NSDistributedLock
//  NSDistributedNotificationCenter
//  NSEnergyFormatter
//  NSEnumerator
//  NSExtensionContext
//  NSExtensionItem
//  NSExtensionRequestHandling
//  NSFileCoordinator
//  NSFilePresenter
//  NSFileVersion
//  NSGarbageCollector
//  NSGeometry
//  NSHFSFileTypes
//  NSHTTPCookie
//  NSHTTPCookieStorage
//  NSHashTable
//  NSHost
//  NSISO8601DateFormatter
//  NSInflectionRule
//  NSItemProvider
//  NSKeyValueCoding
//  NSKeyValueObserving
//  NSKeyedArchiver
//  NSLengthFormatter
//  NSLinguisticTagger
//  NSListFormatter
//  NSMassFormatter
//  NSMeasurement
//  NSMeasurementFormatter
//  NSMetadata
//  NSMetadataAttributes
//  NSMethodSignature
//  NSMorphology
//  NSNetServices
//  NSNotification
//  NSNotificationQueue
//  NSNumberFormatter
//  NSObjectScripting
//  NSOrderedCollectionChange
//  NSOrderedCollectionDifference
//  NSOrthography
//  NSPathUtilities
//  NSPersonNameComponents
//  NSPersonNameComponentsFormatter
//  NSPointerFunctions
//  NSPort
//  NSPortCoder
//  NSPortMessage
//  NSPortNameServer
//  NSProtocolChecker
//  NSRelativeDateTimeFormatter
//  NSScriptCommand
//    NSScriptClassDescription
//    NSScriptCoercionHandler
//    NSScriptCommandDescription
//    NSScriptExecutionContext
//    NSScriptKeyValueCoding
//    NSScriptObjectSpecifiers
//    NSScriptStandardSuiteCommands
//    NSScriptSuiteRegistry
//    NSScriptWhoseTests
//  NSSortDescriptor
//  NSSpellServer
//  NSTextCheckingResult
//  NSURLAuthenticationChallenge
//  NSURLCache
//  NSURLConnection
//  NSURLCredential
//  NSURLCredentialStorage
//  NSURLDownload
//  NSURLError
//  NSURLHandle
//  NSURLProtectionSpace
//  NSURLProtocol
//  NSURLRequest
//  NSURLResponse
//  NSUbiquitousKeyValueStore
//  NSUnit
//  NSUserActivity
//  NSUserNotification
//  NSUserScriptTask
//  NSValueTransformer
//  NSXMLParser
//    NSXMLDTD
//    NSXMLDTDNode
//    NSXMLDocument
//    NSXMLElement
//    NSXMLNode
//    NSXMLNodeOptions
//    NSXPCConnection

