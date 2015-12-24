# play with thrift framework
# To define a service to check where the date is a weekend

include "daocheng_basic.thrift"

namespace java com.daocheng.idl.gen


Service WeekendChecker {
  // To check whether a inputDate is a weekend
  bool isWeekend(1: NormalDate inDate)

}


