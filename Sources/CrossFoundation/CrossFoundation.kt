// =========================================
// GENERATED FILE; EDITS WILL BE OVERWRITTEN
// =========================================
package CrossFoundation
fun String.pad(cellSpan: Int, padding: String = " ", rightAlign: Boolean = false): String {
    var cell: String = this

    while (cell.length > cellSpan) {
        cell = cell.dropLast(1)
    }

    while (cell.length < cellSpan) {
        if (rightAlign) {
            cell = padding + cell
        }
        else {
            cell = cell + padding
        }
    }

    return cell
}

// Kotlin:  Unresolved reference: Range
//    public static func random(in range: Range<Double>) -> Double {
//        return Random().randomDouble()
//    }
// MARK: Utilities
fun dbg(value: String) {
    System.out.println("DEBUG Kotlin: ${value}")
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
