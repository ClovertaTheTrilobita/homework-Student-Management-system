package com.ruoyi.web.controller.student;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.StuClass;
import com.ruoyi.system.service.IStuClassService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 班级Controller
 * 
 * @author SZF
 * @date 2024-12-05
 */
@RestController
@RequestMapping("/system/class")
public class StuClassController extends BaseController
{
    @Autowired
    private IStuClassService stuClassService;

    /**
     * 查询班级列表
     */
    @PreAuthorize("@ss.hasPermi('system:class:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuClass stuClass)
    {
        startPage();
        List<StuClass> list = stuClassService.selectStuClassList(stuClass);
        return getDataTable(list);
    }

    /**
     * 导出班级列表
     */
    @PreAuthorize("@ss.hasPermi('system:class:export')")
    @Log(title = "班级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuClass stuClass)
    {
        List<StuClass> list = stuClassService.selectStuClassList(stuClass);
        ExcelUtil<StuClass> util = new ExcelUtil<StuClass>(StuClass.class);
        util.exportExcel(response, list, "班级数据");
    }

    /**
     * 获取班级详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:class:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuClassService.selectStuClassById(id));
    }

    /**
     * 新增班级
     */
    @PreAuthorize("@ss.hasPermi('system:class:add')")
    @Log(title = "班级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuClass stuClass)
    {
        return toAjax(stuClassService.insertStuClass(stuClass));
    }

    /**
     * 修改班级
     */
    @PreAuthorize("@ss.hasPermi('system:class:edit')")
    @Log(title = "班级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuClass stuClass)
    {
        return toAjax(stuClassService.updateStuClass(stuClass));
    }

    /**
     * 删除班级
     */
    @PreAuthorize("@ss.hasPermi('system:class:remove')")
    @Log(title = "班级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuClassService.deleteStuClassByIds(ids));
    }
}
