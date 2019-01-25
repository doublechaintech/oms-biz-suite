const permissionSettingEnUS = {};
const permissionSettingZhCN = {};

permissionSettingZhCN.ThisObject = '本级目标权限';
permissionSettingEnUS.ThisObject = 'This Object';
permissionSettingZhCN.Test = '测试';
permissionSettingEnUS.Test = 'Test';
permissionSettingZhCN.Error = '错误';
permissionSettingEnUS.Error = 'Error';
permissionSettingZhCN.ErrorLog = '错误日志';
permissionSettingEnUS.ErrorLog = 'Error Log';
permissionSettingZhCN.ReadingPermission = '读取权限';
permissionSettingEnUS.ReadingPermission = 'Reading Permission';
permissionSettingZhCN.No = '否';
permissionSettingEnUS.No = 'No';
permissionSettingZhCN.UpdatePermission = '更新权限';
permissionSettingEnUS.UpdatePermission = 'Update Permission';
permissionSettingZhCN.ManagementPermission = '管理权限';
permissionSettingEnUS.ManagementPermission = 'Management Permission';
permissionSettingZhCN.StartedPermissionCode = '开始权限的代码';
permissionSettingEnUS.StartedPermissionCode = 'Started Permission Code';
permissionSettingZhCN.ListName = '列表名称';
permissionSettingEnUS.ListName = 'List Name';
permissionSettingZhCN.Platform = '平台';
permissionSettingEnUS.Platform = 'Platform';
permissionSettingZhCN.SelectTargetUser = '请选择要操作的用户';
permissionSettingEnUS.SelectTargetUser = 'Select Target User';
permissionSettingZhCN.SelectUser = '请选择用户';
permissionSettingEnUS.SelectUser = 'Select User';
permissionSettingZhCN.PermissionSetting = '权限设置';
permissionSettingEnUS.PermissionSetting = 'Permission Setting';
permissionSettingZhCN.DeletionPermission = '删除权限';
permissionSettingEnUS.DeletionPermission = 'Deletion Permission';
permissionSettingZhCN.Yes = '是';
permissionSettingEnUS.Yes = 'Yes';
permissionSettingZhCN.WritePermission = '写入权限';
permissionSettingEnUS.WritePermission = 'Write Permission';
permissionSettingZhCN.CreatePermission = '新增权限';
permissionSettingEnUS.CreatePermission = 'Create Permission';
permissionSettingZhCN.Email = '邮件';
permissionSettingEnUS.Email = 'Email';
permissionSettingZhCN.ExecutePermission = '执行权限';
permissionSettingEnUS.ExecutePermission = 'Execute Permission';

const oneOf = (value, candidates) => {
  return candidates.filter(item => item == value).length > 0;
};

const isLegalLocale = value => {
  return oneOf(value, ['enUS', 'zhCN']);
};

const determinLocale = userContext => {
  const defaultLocale = 'enUS';
  if (userContext == null) {
    const userLang = navigator.language || navigator.userLanguage;
    const trimedLocale = userLang.replace('-', '');
    if (isLegalLocale(trimedLocale)) {
      return trimedLocale;
    }
  }

  const userLocale = userContext.userLocale;
  if (isLegalLocale(userLocale)) {
    return userLocale;
  }

  return defaultLocale;
};

const internalLocaleName = (key, locale) => {
  if (locale == 'enUS') {
    return permissionSettingEnUS[key];
  }
  if (locale == 'zhCN') {
    return permissionSettingZhCN[key];
  }
  return null;
};

const localeName = (key, locale) => {
  const value = internalLocaleName(key, locale);
  if (value == null) {
    return key + 'NeedToFix';
  }
  return value;
};

const defaultLocaleName = (userContext, key) => {
  const locale = determinLocale(userContext);
  return localeName(key, locale);
};

export default defaultLocaleName;
